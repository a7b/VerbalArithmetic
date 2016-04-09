package hoodie;
public class VerbalArithmetic {

    public static void main(String[] args) {
        String solution = solve("SEND+MORE=MONEY");
        //String solution = solve("AA+BB=CC");
        System.out.println(solution);
    }

    private static String solve(String equation) {
        if (isSolved(equation)) {
            return equation;
        }
        // Find the first letter in the equation
        for (int i = 0 ; i < equation.length() ; i++) {
            if (Character.isLetter(equation.charAt(i))) {

                char letter = equation.charAt(i);
                char firstNumber = '0';

                if (i == 0 ||                           // first digit of a
                        i == equation.indexOf('+') + 1 ||   // first digit of b
                        i == equation.indexOf('=') + 1) {   // first digit of c
                    firstNumber = '1';
                }

                // Try all unused numbers as replacements
                for (char n = firstNumber ; n <= '9' ; n++) {
                    // Ensure the number is not already used
                    if (equation.indexOf(n) < 0) {

                        // Replace the letter with the number and try solving.
                        String newEquation = equation.replace(letter, n);
                        String result = solve(newEquation);
                        if (result != null) {
                            return result;
                        }
                    }
                }

                return null;
            }
        }

        return null;
    }

    private static boolean isSolved(String equation) {
        // Check if there is a letter in the equation
        for (int i = 0 ; i < equation.length() ; i++) {
            if ( Character.isLetter(equation.charAt(i)) ) {
                return false;
            }
        }

        // Get the parts of the string a + b = c
        String a = equation.substring(0, equation.indexOf('+'));
        String b = equation.substring(equation.indexOf('+') + 1, equation.indexOf('='));
        String c = equation.substring(equation.indexOf('=') + 1);

        if (Integer.parseInt(a) + Integer.parseInt(b) == Integer.parseInt(c)) {
            return true;
        }

        return false;
    }

}
