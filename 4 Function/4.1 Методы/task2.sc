def sendGift(currentAmount: Int, gift: => Int) = {
  if (currentAmount >= 500)
    currentAmount + gift
  else
    currentAmount
}

val accountAmounts = List(100, 200, 500, 300, 700)