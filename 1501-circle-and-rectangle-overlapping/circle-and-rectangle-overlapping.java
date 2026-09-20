class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int xRect = Math.max(x1 , Math.min(xCenter , x2));
        int yRect = Math.max(y1 , Math.min(yCenter , y2));

        long distance = (xRect-xCenter)*(xRect-xCenter) + (yRect-yCenter)*(yRect-yCenter);

        return (distance <= radius*radius);
    }
}