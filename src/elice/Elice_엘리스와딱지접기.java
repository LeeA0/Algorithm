package elice;

import java.util.Scanner;

class Rectangle {
	int width;
	int height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int area() {
		return this.width * this.height;
	}
}

class Square extends Rectangle {
	int side;

	public Square(int side) {
		super(side, side);
		this.side = side;
	}

	@Override
	public int area() {
		return this.side * this.side;
	}
}

public class Elice_엘리스와딱지접기 {
	public static void main(String[] args) throws Exception {
		int t;
		Scanner scan = new Scanner(System.in);

		t = scan.nextInt();

		if (t == 1) {
			Rectangle rect = new Rectangle(scan.nextInt(), scan.nextInt());
			System.out.println(rect.area());
		} else {
			Square sq = new Square(scan.nextInt());
			System.out.println(sq.area());
		}
	}
}
