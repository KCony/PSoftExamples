method TriangleNumber(N: int) returns (t: int)
  requires N >= 0
  ensures t == N * (N + 1) / 2
{
  t := 0;
  var n := 0;
  while n < N
    invariant 0 <= n <= N
    invariant t == n * (n + 1) / 2
    decreases N - n
  {
    print "Before  ", n, " ", t, "\n";
    n, t := n + 1, t + n + 1;
    print "After  ", n, " ", t, "\n";
  }
}

method Main() {
  var res := TriangleNumber(3);
  print res, "\n";
}