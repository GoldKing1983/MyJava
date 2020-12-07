public class UberPerfectCity {
  double perfectCity(double[] departure, double[] destination) {
    double minorVert = 0;
    double minorHor = 0;

    minorVert = minorDistance(departure[1], destination[1]);
    minorHor = minorDistance(departure[0], destination[0]);

    return minorVert + minorHor;
  }

  double minorDistance(double a, double b) {
    if (a == b) return 0;

    if (!isInBetween(a, b)) {
      double left = floor(a);
      left = (a - left) + (b - left);
      double right = ceil(a);
      right = (right - a) + (right - b);

      return left < right ? left : right;
    }
    double min = min(a, b);
    double max = max(a, b);
    double minRight = ceil(min);

    return (minRight - min) + (max - minRight);
  }

  double min(double a, double b) {
    return a < b ? a : b;
  }

  double max(double a, double b) {
    return a > b ? a : b;
  }

  /**
   * Check wether there is road between them.
   *
   * @return true if there is road(s) between a and b.
   */
  boolean isInBetween(double a, double b) {
    if (a < 0.0 && b > 0.0) return true;
    if (a > 0.0 && b < 0.0) return true;
    return floor(a) != floor(b);
  }

  double abs(double input) {
    if (input > 0.0) return input;
    return 0.0 - input;
  }

  double floor(double input) {
    return input - (input % 1.0);
  }

  double ceil(double input) {
    if (input % 1.0 == 0.0) {
      return input;
    }
    return floor(input) + 1;
  }
}
