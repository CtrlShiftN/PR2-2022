package exer.chap09.ex1;

import utils.DomainConstraint;

/**
 * @overview 
 *  Represents a fixed set of colors, each of which is defined with a color code.
 *  
 */
public enum Color {
  /** red */
  R("#FF0000"),  
  /** orange */
  O("#FF8000"),
  /** yellow */
  Y("#FFFF33"),  
  /** blue */
  B("#000066"),  
  /** purple */
  P("#6600CC");

  @DomainConstraint(mutable=false,optional=false)
  private String colorCode;
  
  // constructor
  private Color(String code) {
    this.colorCode = code;
  }
  
  /**
   * @effects 
   *  return this.colorCode
   */
  public String getColorCode() {
    return colorCode;
  } 
}
