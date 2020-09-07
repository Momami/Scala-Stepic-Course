import scala.math.BigDecimal.RoundingMode.HALF_UP

def crispsWeight(weight: BigDecimal, potatoWaterRatio: Double, crispsWaterRatio: Double): BigDecimal = {
  val x = (potatoWaterRatio * weight - crispsWaterRatio * weight) / (1 - crispsWaterRatio)
  (weight - x).setScale(5, HALF_UP)
}

crispsWeight(90.0, 0.9, 0.1)