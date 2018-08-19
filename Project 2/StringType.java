class StringType implements AnyType {
	
   private String word;

   public StringType(){
       word = "";
   }

   public StringType(String s){
        word = s;
   }

   public boolean isBetterThan(AnyType datum) {
	return (this.word.compareTo(((StringType)datum).word) > 0);
   }

   public boolean isLessThan(AnyType datum) {
	return (this.word.compareTo(((StringType)datum).word) < 0);
   }

   public String toString() {
	return word;
   }
}
