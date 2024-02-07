method FindZero(a: array?<nat>) returns (index: int)
  ensures a == null ==> index == -1
  ensures (a != null && index < 0) ==> forall i :: 0 <= i < a.Length ==> a[i] != 0
  ensures 0 <= index ==> index < a.Length && a[index] == 0
{
  index := 0;
  if (a == null) {
    index := -1;
    return;
  }
  while index < a.Length
    invariant forall k :: 0 <= k < index && k < a.Length ==> a[k] != 0
  {
    if a[index] == 0 { return; }
    index := index + 1;
  }
  index := -1;
}

method Main() {
  var arr := null;
  var a: int := FindZero(arr);
  print a;
  arr := new nat[][3, 4, 0, 17];
  a := FindZero(arr);
  print a;
}