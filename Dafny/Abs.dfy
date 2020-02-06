method  Abs(x: int) returns (x’: int)
  ensures x’ >= 0
  ensures (x < 0 && x’ ==  -1*x) || (x’ == x)
{
  x’ := x;
  if(x’ < 0) { x’ := x’ *  -1; }
}

method Testing()
{
   var v := Abs(3);
   assert v == 3;
   assert 0 < v;
   assert 0 <= v;
   v := Abs(0);
   // assert 0 < v;
}