function method Log2 (n: nat): nat
  requires n > 0
  decreases n
{
  if n == 1 then 0 else 1 +  Log2 ( n / 2 )
}

method Main() {
  var a: int := Log2(1);
  print a;
  print "\n";
  a := Log2(8);
  print a;
  print "\n";
  a := Log2(1024);
  print a;
  print "\n";
}
