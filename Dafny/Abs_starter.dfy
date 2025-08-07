method Abs(x: int) returns (x': int)
{
  x' := x;
  if (x' < 0) { x' := x' *  -1; }
}

method Testing()
{
   var v := Abs(3);
   assert v == 3;
   // assert 0 < v;
   // assert 0 <= v;
   // v := Abs(0);
   // assert 0 < v;
}