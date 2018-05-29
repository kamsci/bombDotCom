public class BombDotComGame {
    public int maxRounds = 5;
    public boolean didWin = false;
    public DotCom pets;

    public BombDotComGame() {
        // Initialize DotComs
        pets = new DotCom("www.chewy.com");
    }

    public void playGame() {
        System.out.println("BOMB! .com");
        System.out.println("A battleship style game with url's. You have 5 chances to sink the battle-url by guessing its position on a row of 7.");
        System.out.println(" ");
        while (continueGame()) {
            String guess = GameHelper.getUserInput("Attack!");
            playRound(guess);
            maxRounds--;
        }
        if (!didWin){
            System.out.println("You lost... better luck next time.");
        }
    }

    private void playRound(String guess){
//        System.out.println("locations " + pets.getLocations());

        String status = pets.checkYourSelf(guess);
//        System.out.println("Guess... " + guess);
        System.out.println(status);
//        System.out.println("Sunk? " + pets.isSunk());
//        System.out.println("Hits? " + pets.getHits());
        System.out.println(" ");

        if (pets.isSunk()) {
            System.out.println("You Won!");
            didWin = true;
        }
    }

    private boolean continueGame() {
        if (maxRounds <= 0 || didWin) {
            return false;
        }
        return true;
    }

    // Ask for guess
    // check dotComs for hits
    // tell status of game
    // start over on win or lose

}
