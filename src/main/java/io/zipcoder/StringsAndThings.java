package io.zipcoder;


import org.apache.maven.shared.utils.StringUtils;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        int count = 0;
        input = input.toLowerCase() + " ";
        for (int i = 0; i < input.length() - 1; i++) {
            if ((input.charAt(i) == 'y' || input.charAt(i) == 'z') && !Character.isLetter(input.charAt(i + 1))) {
                count++;
            }
        }
        return count;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        String baseLowerCase = base.toLowerCase(); // convert base string to lowercase
        String removeLowerCase = remove.toLowerCase(); // convert remove string to lowercase
        int removeLength = removeLowerCase.length(); // get the length of remove string
        StringBuilder result = new StringBuilder(); // initialize a StringBuilder to store the result
        int startIndex = 0; // initialize the start index for searching remove string

        while (true) {
            int index = baseLowerCase.indexOf(removeLowerCase, startIndex); // search for the remove string in the base string
            if (index == -1) { // if remove string is not found, append the remaining base string to the result and break the loop
                result.append(base.substring(startIndex));
                break;
            } else { // if remove string is found, append the base string before the remove string to the result and update the start index
                result.append(base.substring(startIndex, index));
                startIndex = index + removeLength;
            }
        }

        return result.toString();
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input) {
        int c = StringUtils.countMatches(input, "not");
        int c1 = StringUtils.countMatches(input, "is");
        if (c == c1) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        if (input.length() < 2) { // check if input length is less than 2
            return true;
        }
        for (int i = 1; i < input.length() - 1; i++) { // iterate over each character in the input string
            if (input.charAt(i) == 'g' && input.charAt(i - 1) != 'g' && input.charAt(i + 1) != 'g') { // check if the current g is not happy
                return false;
            }
        }
        return true;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int count = 0;
        if (input.length() < 3) { // check if input length is less than 3
            return 0;
        }
        for (int i = 0; i < input.length() - 2; i++) { // iterate over each character in the input string
            char currentChar = input.charAt(i);
            if (currentChar == input.charAt(i + 1) && currentChar == input.charAt(i + 2)) { // check if the current char is repeated three times in a row
                count++;
            }
        }
        return count;
    }
}
