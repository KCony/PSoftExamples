method DivisionByZero(x: int) returns (y: int)
  requires x == 1 || x == -2
  ensures y == 0
{
  y := x + 4;
  if (x > 0) {
    y := x*x - 1;
  } else {
    y := y + x;
  }
}