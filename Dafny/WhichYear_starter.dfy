// a function returning a bool
predicate isLeapYear(y: int) {
  y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)
}

// Does this method terminate?
method WhichYear_InfiniteLoop(d: int) returns (year: int) {
  var days := d;
  year := 1980;
  while days > 365 {
    if isLeapYear(year) {
      if days > 366 {
        days := days - 366;
        year := year + 1;
      }
    } else {
      days := days - 365;
      year := year + 1;
    }
  }
}
