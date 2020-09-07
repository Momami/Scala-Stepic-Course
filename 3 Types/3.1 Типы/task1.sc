import Math.{sqrt, PI, exp, pow}
def normalDistribution(mu: Double, sigma: Double, x: Double): Double = {
  // put your code here
  1 / (sigma * sqrt(2 * PI)) * exp(-pow(x - mu, 2) / (2 * sigma * sigma))
}

