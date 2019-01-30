import java.util.*;

class ZHKH {
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		float ColdWater = 38.06f;
		float HotWater = 188.53f;
		float T1 = 6.46f;
		float T2 = 1.92f;
		float T3 = 5.38f;
		
		System.out.println("Input used cold water:");
		float coldWater = sc.nextFloat() * ColdWater;
		System.out.println("Input used hot water:");
		float hotWater = sc.nextFloat() * HotWater;
		System.out.println("Input used EE of T1:");
		float t1 = sc.nextFloat() * T1;
		System.out.println("Input used EE of T2:");
		float t2 = sc.nextFloat() * T2;
		System.out.println("Input used EE of T3:");
		float t3 = sc.nextFloat() * T3;
		
		System.out.println("For payment you need: " + (coldWater + hotWater + t1 + t2 + t3) + " rub");
	}
}


