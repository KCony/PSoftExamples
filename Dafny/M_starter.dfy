// Can you make the program verify?
method M(n: int) returns (r: int)
  // what precondition do we need?
  ensures r == n
{
  var i := 0;
  while i < n
  // what invariant do we need here?
  {
    i := i + 1;
  }
  r := i;
}
