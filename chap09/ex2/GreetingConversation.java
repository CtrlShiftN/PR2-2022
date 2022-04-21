package exer.chap09.ex2;

import exer.chap07.ex1.MobilePhone;
import exer.chap07.ex1.Person;
import utils.NotPossibleException;

/**
 * @overview
 *  A program that demonstrates how to use {@link Person} and {@link MobilePhone}.
 *  
 * @author dmle
 *  
 */
public class GreetingConversation {
  
  // singleton
  private static GreetingConversation instance;
  
  private GreetingConversation() {}
  
  /**
   * @effects 
   *  if instance is null
   *    initialise it 
   *  return instance 
   */
  public static GreetingConversation getInstance() {
    if (instance == null) {
      instance = new GreetingConversation();
    }
    
    return instance;
  }
  
  /**
   * The main method
   * @effects <pre>
   *  create a {@link MobilePhone} m 
   *  create a {@link Person} object p with phone m
   *  display an error message if failed
   * </pre>
   */
  public static void main(String[] args) {
      
    GreetingConversation gc = GreetingConversation.getInstance();
    
    gc.run();
    
    GreetingConversation gc2 = GreetingConversation.getInstance();
    
    System.out.printf("Same instance? %b%n", gc == gc2);
  }

  /**
   * @effects 
   */
  private void run() {
    // create a new MobilePhone
    MobilePhone m1 = null;
    try {
      m1 = new MobilePhone("Samsung", "Galaxy S3", 'B', 2014);
      // display phone
      System.out.println("Created: " + m1);
    } catch (NotPossibleException e) {
      System.err.println("-> Failed to create mobile phone");
      e.printStackTrace();
    }

    try {
      // create a new Person with that phone
      Person p1 = new Person(1, "Duc Le");
      // display phone
      System.out.println("Created: " + p1);

      // assign phone to person
      p1.setPhone(m1);
      // display phone
      System.out.println("  has phone: " + p1.getPhone());
    } catch (NotPossibleException e) {
      // error creating person
      System.err.println("-> Failed to create person");
      e.printStackTrace();
    }    
  }
}
