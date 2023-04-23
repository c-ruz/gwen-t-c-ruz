package cl.uchile.dcc
package gwent.Cards

import java.util.Objects

class WeatherCard(val name: String) extends Card with Equals {
  override def canEqual(that: Any): Boolean = that.isInstanceOf[WeatherCard]

  override def equals(obj: Any): Boolean = {
    if (canEqual(obj: Any)) {
      val other = obj.asInstanceOf[WeatherCard]
      (this eq other) ||
        (this.name == other.name)
    } else {
      false
    }
  }

  override def hashCode(): Int = Objects.hash(classOf[WeatherCard], name)
}
