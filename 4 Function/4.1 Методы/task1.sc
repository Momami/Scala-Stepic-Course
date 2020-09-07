def fibs(num: Int): Long = {
  if (num == 1 || num == 2) 1
  else fibs(num - 1) + fibs(num - 2)
}
