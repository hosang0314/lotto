package lotto;

import java.util.Scanner;

public class day06ws {

	public static void main(String[] args) {
		System.out.print("6개의 숫자입력 (범위 : 1~45):");
		int my[] = new int[6];
		int lot[] = new int[6];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < my.length; i++) {
			my[i] = sc.nextInt();
			if(my[i]<1||my[i]>45) {
                System.out.println("입력 범위 초과하였습니다. 1~45까지의 숫자로 다시 입력해주세요.");
                i--;
                continue;
            }
		}
		for (int i = 0; i < lot.length; i++) {
			lot[i] = ((int) (Math.random() * 45)) + 1;
			for (int j = 0; j < lot.length; j++) {
				if (lot[i] == lot[j]) {
					lot[i] = ((int) (Math.random() * 45)) + 1;
				}
			}
		}
		long money = 0l;
		while (true) {
			money = ((long) (Math.random() * 9999999999l)) + 1;
			if(money >= 1000000000l && money <= 10000000000l)
				break;
		}
		int lottocount = 0;
		for (int i = 0; i < my.length; i++) {
			for (int j = 0; j < lot.length; j++) {
				if (my[i] == lot[j])
					lottocount++;
			}
		}
		int lottoking = 0;
		long mymoney = 0l;
		switch (lottocount) {
		case 3:
			lottoking = 4;
			mymoney = (long) (money*0.05);
			break;
		case 4:
			lottoking = 3;
			mymoney = (long) (money*0.1);
			break;
		case 5:
			lottoking = 2;
			mymoney = (long) (money*0.2);
			break;
		case 6:
			lottoking = 1;
			mymoney = (long) (money*0.5);
			break;
		default:
			
		}
		System.out.print("내 번호 : ");
		for (int i = 0; i < my.length; i++) {
			System.out.print(my[i]+"\t");
		}
		System.out.println();
		System.out.print("당첨번호는 : ");
		for (int i = 0; i < lot.length; i++) {
			System.out.print(lot[i]+"\t");
		}
		System.out.println();
		System.out.println("등수 : "+lottoking);
		String total = String.format("%,d", money);
		System.out.println("총 당첨금 : "+total+"원 입니다.");
		String mytotal = String.format("%,d", mymoney);
		System.out.println("당첨금은 "+mytotal+"원 입니다.");
		
	}
}
