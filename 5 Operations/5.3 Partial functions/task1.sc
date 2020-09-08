val log: PartialFunction[Double, Double] = {
  case x: Double if x > 0 => Math.log(x)
}