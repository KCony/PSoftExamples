// https://en.wikipedia.org/wiki/Cube_(algebra)
// http://web.cs.ucla.edu/~klinger/cubvis_6_15_01.htm

method Cube(N: int) returns (c: int)
  requires 0 <= N
  ensures c == N*N*N
{
  c := 0;
  var n, k, m := 0, 1, 6;

  while n < N
    invariant n <= N
    invariant c == n*n*n
    invariant k == 3*n*n + 3*n + 1
    invariant m == 6*n + 6
  {
    print "n = ", n, " c = ", c, " k = ", k, " m = ", m, "\n";
    c := c + k;
    print "n = ", n, " c = ", c, " k = ", k, " m = ", m, "\n";
    k := k + m;
    print "n = ", n, " c = ", c, " k = ", k, " m = ", m, "\n";
    m := m + 6;
    print "n = ", n, " c = ", c, " k = ", k, " m = ", m, "\n";
    n := n + 1;
    print "n = ", n, " c = ", c, " k = ", k, " m = ", m, "\n";
    print "------------------------------\n";
  }
}

method Main() {
  var c := Cube(4);
}

