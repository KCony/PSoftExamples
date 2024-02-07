method TriangleNumber(N: int) returns (t: int)
  requires N >= 0
  ensures t == N * (N + 1) / 2
{
  t := 0;
  var n := 0;
  while n < N
  {
    n, t := n + 1, t + n + 1;
  }
}
