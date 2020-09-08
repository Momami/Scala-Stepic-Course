val list = List(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150)
list.filter(x => x < 100 && x % 4 == 0).map(_ / 4).init.foreach(println)