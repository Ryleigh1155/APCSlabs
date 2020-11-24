
/**
 * A program to carry on conversations with a human user.
 * This version:
 * <ul><li>
 * Uses advanced search for keywords
 * </li></ul>
 *
 * @author Laurie White
 * @version April 2012
 */
public class Magpie3
{
    /**
     * Get a default greeting
     *
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     *
     * @param statement
     * the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (findKeyword(statement, "no") >= 0 || findKeyword(statement, " not ") >= 0)
        {
            response = "Why so negative?";
        }
        else if ((findKeyword(statement, "mother") >= 0) || 
                 (findKeyword(statement, "father") >= 0) ||
                 (findKeyword(statement, "brother") >= 0) ||
                 (findKeyword(statement, "sister") >= 0))
        {
            response = "Tell me more about your family.";
        }
        else if (findKeyword(statement, "Disney") >= 0)
        {
            response = "I like Mickey too.";
        }
        else if (findKeyword(statement, "athlete") >= 0)
        {
            response = "Talk to me about sports.";
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }

    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no").
     *
     * @param statement
     * the string to search
     * @param goal
     * the string to search for
     * @param startPos
     * the character of the string to begin the
     * search at
     * @return the index of the first occurrence of goal in
     * statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal,
    int startPos)
    {
        //trim() removes white space before and after letters of a string
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();
        int index = -1;

        boolean front = false;
        boolean back = false;

        index = statement.indexOf(goal);

        while(index > -1)
        {
            System.out.println("/t" + index); //output where in statement goal was found
            //check the front side

            if(index == 0)//goal is the first word
            {
                front = true;
            }
            else
            {
                String firstLet = statement.substring(index-1, index);
                if(firstLet.equals(" "))//if(statement.substring(index1, index).equals(" "));
                {
                    front = true;
                }
            }
            
            //short circuiting (cuts off if one OR is true, or one AND is false
            //if(index == 0 || statement.substring(index-1, index).equals(" "))
            //if(num != 0 && 100/num <1)
            
            
            //check the last side
            int lastIndex = goal.length() + index;
            if(lastIndex == statement.length())
            {
                back = true;
            }

            else
            {
                String lastLet = statement.substring(lastIndex, lastIndex+1);
                if(lastLet.equals(" "))//if(statement.substring(index1, index).equals(" "));
                {
                    back = true;
                }
            }
            // write code that will test if the letter prior to goal is a space
            
            
            //&& means AND, || means OR
            if(front == true && back == true) //if(front && back )
            {
                return index;
            }
            
            index = statement.indexOf(goal, index+1);

        }
        return index;

    }

    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no"). The search
     * begins at the beginning of the string.
     *
     * @param statement
     * the string to search
     * @param goal
     * the string to search for
     * @return the index of the first occurrence of goal in
     * statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword(statement, goal, 0);
    }

    /**
     * Pick a default response to use if nothing else fits.
     *
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 8;
        double r = Math.random();
        int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "Talk to me more.";
        }
        else if (whichResponse == 5)
        {
            response = "I like that.";
        }
        else if (whichResponse == 6)
        {
            response = "Is that good?";
        }
        else if (whichResponse == 7)
        {
            response = "Sounds great.";
        }

        return response;
    }
}
