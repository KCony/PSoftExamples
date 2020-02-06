// Can you make the program verify?
method M(n: int) returns (r: int)
  requires n >= 0
  ensures r == n
{
  var i := 0;
  while i < n
    invariant i <= n
  {
    i := i + 1;
  }
  r := i;
}
