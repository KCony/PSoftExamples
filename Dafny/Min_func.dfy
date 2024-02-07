function min(a: int, b: int ): int
{
  if a < b then a else b
}

method Main() {
  var a: int := min(3, 11);
  print "The minimum of 3 and 11 is ", a, "\n";
}