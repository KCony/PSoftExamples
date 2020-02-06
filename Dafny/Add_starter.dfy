method Add(x: int, y: int) returns (r: int)
  requires 0 <= x && 0 <= y
  ensures r == 2 * x + y
{
  r := x;
  var n := y;
  while n != 0
  {
    r := r + 1;
    n := n - 1;
  }
}
