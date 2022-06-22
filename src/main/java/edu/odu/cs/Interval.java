package edu.odu.cs;

import java.util.NoSuchElementException;


public class Interval {
  private double low;
  private double high;

 
  public Interval(double min, double max) {
    low = min;
    high = max;
  }


  public boolean empty() {
    return high < low;
  }

 
  public boolean contains(double d) {
    return d >= low && d <= high;
  }


  public boolean overlaps(Interval x) {
    if (empty() || x.empty()) {
      return false;
    }
    return !(low > x.high || high < x.low);
  }

 
  public double width() {
    return Math.max(0.0, high - low);
  }

  public double getMin() {
    if (!empty()) {
      return low;
    } else {
      throw new NoSuchElementException("getMin() called on an empty interval");
    }
  }


  public double getMax() {
    if (!empty()) {
      return high;
    } else {
      throw new NoSuchElementException("getMax() called on an empty interval");
    }
  }


  public Interval below(double d) {
    return new Interval(low, Math.min(d, high));
  }

 
  public Interval above(double d) {
    return new Interval(Math.max(d, low), high);
  }


  public boolean equals(Object obj) {
    if (obj instanceof Interval) {
      Interval other = (Interval)obj;
      if (empty() && other.empty()) 
        return true;
      return (low == other.low) && (high == other.high);
    } else {
      return false;
    }
  }

  public String toString() {
    return "(" + low + ',' + high + ')';
  }
}
// This is from master