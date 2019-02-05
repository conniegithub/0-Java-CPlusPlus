class P2 {
   public static void main(String args[]) {
      boolean correct = false;
      char selection = 'B';
      int number = 2006;
      int difference = number - 1996;

      System.out.print("Welcome to Trivia!");
      System.out.print("\n\n Question #1: Who was the first UF player to win the Heisman Trophy?");
      System.out.println("\n\n\t A" + ")" + "Danny Wuerffel");
      System.out.println("\t B" + ")" + "Steve Spurrier");
      System.out.println("\t C" + ")" + "Emmitt Smith");
      System.out.print("\n\t Your Answer?  ");
      selection = UserInput.readChar();

        if (selection == 'B' || selection == 'b') {
        System.out.print("\n\t Your answer is true!");
     }
        else {
        System.out.print("\n\t Your answer is false!");
     }

      System.out.print("\n\n Question #2: What year did UF win its first NCAA Football National Championship?");
      System.out.print("\n\t Your Answer?  ");
      number = UserInput.readInt();
      difference = number - 1996;

        if (number == 1996) {
        System.out.print("\n\t Your answer is true!");
     }
        else if (number != 1996) {
        System.out.print("\n\t Your answer is false!");
        System.out.print("\n\t The difference between your answer and the correct answer is:");
        System.out.print("\n\n\t" + number + '-' + 1996 + '=' + difference);
     }
        else {
        System.out.print("\n\t Your answer is not a number.");
     }

      System.out.print("\n\n Question #3: Who is the President of the University of Florida?");
      System.out.println("\n\n\t A" +")" + "Bernie Machen");
      System.out.println("\t B" + ")" + "John Lombardi");
      System.out.println("\t C" + ")" + "Stephen C. O' Connell");
      System.out.print("\n\t Your Answer?  ");
      selection = UserInput.readChar();

        if (selection == 'A' || selection == 'a') {
        System.out.print("\n\t Your answer is true!");
     }
        else {
        System.out.print("\n\t Your answer is false!");
     }

      System.out.print("\n\n Thanks for playing Trivia.");
    }
}