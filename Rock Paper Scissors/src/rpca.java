import java.util.*;
public class rpca {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		int choice = choice(keyboard);
		String computer = comchoice();
		System.out.println("The computer chose " + computer);
		if (choice == 1 && computer.equals("Rock")) {
			System.out.println("Its a Tie");
		}else {
			if (choice == 1 && computer.equals("Paper")) {
				System.out.println("Paper beats Rock, you lose");
			}else {
				if (choice == 1 && computer.equals("Scissors")) {
					System.out.println("Rock beats Scissors, you win");
				}else {
					if (choice == 2 && computer.equals("Rock")) {
						System.out.println("Paper beats Rock, you win");
					}else {
						if (choice == 2 && computer.equals("Paper")) {
							System.out.println("Its a tie");
						}else {
							if (choice == 2 && computer.equals("Scissors")) {
								System.out.println("Scissors beats Paper, you lose");
							}else {
								if (choice == 3 && computer.equals("Rock")) {
									System.out.println("Rock beats Scissors. you lose");
								}else {
									if (choice == 3 && computer.equals("Paper")) {
										System.out.println("Scissors beats Paper,you win");
									}else {
										if (choice == 3 && computer.equals("Scissors")) {
											System.out.println("Its a tie");
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
	}
	public static int choice (Scanner in) {
		System.out.print("Enter Rock, Paper, or Scissors: ");
		String choice = in.nextLine();
		int choice2 = 0;
		if(choice.equalsIgnoreCase("Rock")||choice.equalsIgnoreCase("R")) {
			choice2 =  1;
		}else {
			if (choice.equalsIgnoreCase("Paper")||choice.equalsIgnoreCase("P")) {
				choice2 = 2;
			}else {
				if (choice.equalsIgnoreCase("Scissors")||choice.equalsIgnoreCase("S")) {
					choice2 = 3;
				}else {
					while(choice.isEmpty()||!choice.equalsIgnoreCase("Rock")||!choice.equalsIgnoreCase("R")||!choice.equalsIgnoreCase("Paper")||choice.equalsIgnoreCase("P")||!choice.equalsIgnoreCase("Scissors")||choice.equalsIgnoreCase("S")) {
						System.out.println("Error! Enter Rock, Paper, or Scissors: ");
						choice = in.nextLine();
						if(choice.equalsIgnoreCase("Rock")||choice.equalsIgnoreCase("R")) {
							choice2 =  1;
							break;
						}else {
							if (choice.equalsIgnoreCase("Paper")||choice.equalsIgnoreCase("P")) {
								choice2 = 2;
								break;
							}else {
								if (choice.equalsIgnoreCase("Scissors")||choice.equalsIgnoreCase("S")) {
									choice2 = 3;
									break;
								}
							}	
						}
					}
				}
			}
		}
		return choice2;
	}
	
	public static String comchoice () {
		int comChoice = ((int)Math.random()*3+1);
		String str = "";
		if (comChoice == 1) {
			str = "Rock";
		}else {
			if (comChoice == 2) {
				str = "Paper";
			}else {
				if(comChoice == 3) {
					str = "Scissors";
				}
			}
		}
		return str;
	}
}


