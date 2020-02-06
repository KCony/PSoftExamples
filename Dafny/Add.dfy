method Add(x: int, y: int) returns (r: int)
  requires 0 <= x && 0 <= y
  ensures r == x + y
{
  r := x;
  var n := y;
  while n != 0
    invariant r == x+y-n && 0 <= n
  {
    r := r + 1;
    n := n - 1;
  }
}

method Main() {
  var a: int := Add(3, 11);
  print a;
}
