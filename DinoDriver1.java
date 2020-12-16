
/**
 * Write a description of class DinoDriver1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DinoDriver1
{
    public static void main(String[] args)
    {
        Dinosaur d1 = new Dinosaur();
        Dinosaur d2 = new Dinosaur("TRex");
        
        Dinosaur[] pop = new Dinosaur[10]; // index 0-9, 10 slots
        
        for(int i = 0; i < pop.length; i++) //loop
        {
            pop[i] = new Dinosaur("TRex");
        }
        
        // Age up all dinos to a random age between 0-35
        for(int i = 0; i < pop.length; i++)
        {
            int rand = (int)(Math.random()*35);
            for(int j = 0; j < rand; j++)
            {
                pop[i].ageUp();
            }
        }
        
        for(int i = 0; i < pop.length; i++) //loop
        {
            System.out.println(pop[i]);
        }
    }
}
