  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to multiply the value of a BrobIntk passed as argument to this BrobInt
   *  @param  gint         BrobInt to multiply by this
   *  @return BrobInt that is the product of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt multiply( BrobInt gint ) {
    new BrobInt reversedBrobInt1 = reverser(this); //gets cut in half
    new BrobInt reversedBrobInt2 = reverser(gint);
    new BrobInt temp1;
    new BrobInt temp2;
    new BrobInt product = 0;
    while (reversedBrobInt1 > 1) {
      reversedBrobInt1 = reversedBrobInt1.divide(2);
      temp2 = reversedBrobInt2.add(reversedBrobInt2); //doubles
      if (reversedBrobInt1.value % 2 != 0) {
        product += reversedBrobInt1.add(reversedBrobInt2);
      }
    }
  }
