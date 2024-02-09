method Add(x: int, y: int) returns (r: int)
  //requires 0 <= x && 0 <= y
  ensures r == x + y
{
  var x', y' := 0, 0;
  var flip := false;
  if x < 0 && y < 0 {
    x' := -x;
    y' := -y;
    flip := true;
  }
  else if y < 0 {
    x' := y;
    y' := x;
  }
  else {
    x' := x;
    y' := y;
  }
  r := x';
  var n := y';
  while n > 0
    invariant r == x' + y' - n && 0 <= n
  {
    r := r + 1;
    n := n - 1;
  }
  if flip {
    r := -r;
  }
}

method Main() {
  var a: int := Add(3, 11);
  print a, "\n";
  a := Add(-3, 11);
  print a, "\n";
  a := Add(3, -11);
  print a, "\n";
  a := Add(-3, -11);
  print a, "\n";
}