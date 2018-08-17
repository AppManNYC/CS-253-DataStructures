/* 		Created By: 		Matthew A. Krieger
 * 		Date:			October 04, 2015
 * 		Assignment:		Homework I
 */

class IntegerType implements AnyType {

   private int number;

   public IntegerType() {
       number = 0;
   }
   
   public IntegerType(int i) { 
       number = i;
   }

   public boolean isBetterThan(AnyType datum) {
	return (this.number > ((IntegerType)datum).number);
   }
   
   public boolean isLessThan(AnyType datum) {
	return (this.number < ((IntegerType)datum).number);
   }

   public int toInteger() {
	return number;
   }
}


