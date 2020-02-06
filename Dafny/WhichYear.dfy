// a function returning a bool
predicate method isLeapYear(y: int) { 
  y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)
}

// Does this method terminate?
method WhichYear_InfiniteLoop(d: int) returns (year: int)
requires d > 0
ensures year >= 1980
{
  var days := d;
  year := 1980;
  while days > 365
  decreases days
  {
    if isLeapYear(year) {
      if days > 366 {
        days := days - 366;
        year := year + 1;
      }
      else {
        break;
      }
    } else {
      days := days - 365;
      year := year + 1;
    }
  }
}

method Main() {
  var v := WhichYear_InfiniteLoop(1);
  print v, "\n";
  v := WhichYear_InfiniteLoop(20);
  print v, "\n";
  v := WhichYear_InfiniteLoop(365);
  print v, "\n";
  v := WhichYear_InfiniteLoop(366);
  print v, "\n";
  v := WhichYear_InfiniteLoop(367);
  print v, "\n";
  v := WhichYear_InfiniteLoop(1480);
  print v, "\n";
  v := WhichYear_InfiniteLoop(14401);
  print v, "\n";
  v := WhichYear_InfiniteLoop(14646);
  print v, "\n";
}
