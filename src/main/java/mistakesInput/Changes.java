package mistakesInput;

/**
 * change the format of coordinates to make checks more convenient.
 */
public class Changes {
    /**
     * @param coordinate that is prompted of the user.
     * @return coordinate number.
     */
    public static int separateNumberCoordinate(String coordinate) {
        char number = coordinate.charAt(1);
        int numberCoordinate;
        numberCoordinate = Character.getNumericValue(number);
        return numberCoordinate;
    }

    /**
     * @param coordinate that is prompted of the user.
     * @return coordinate letter.
     */
    public static char separateLetterCoordinate(String coordinate) {
        char letter = coordinate.charAt(0);
        return letter;
    }
}


