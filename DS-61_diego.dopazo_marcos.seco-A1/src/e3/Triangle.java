package e3;

import java.util.Arrays;
public record Triangle(float angle0, float angle1, float angle2) {
    public Triangle {
        /*The angles of a triangle must add to 180, if not its incorrect
          we throw an IllegalArgumentException*/
        float sumOfAngles = angle0 + angle1 + angle2;
        if(sumOfAngles != 180){
            throw new IllegalArgumentException();
        }
    }

    public Triangle ( Triangle t ) {
        this(t.angle0, t.angle1, t.angle2);
    }

    public boolean isRight(){
        return angle0 == 90 || angle1 == 90 || angle2 == 90;
    }

    public boolean isAcute () {
        return angle0 < 90 && angle1 < 90 && angle2 < 90;
    }

    public boolean isObtuse () {
        return angle0 > 90 || angle1 > 90 || angle2 > 90;
    }

    public boolean isEquilateral () {
        return angle0 == angle1 && angle1 == angle2;
    }

    public boolean isIsosceles () {
        if(isEquilateral()){
            return false;
        }
        return angle0 == angle1 || angle1 == angle2 || angle0 == angle2;
    }

    public boolean isScalene () {
        return angle0 != angle1 && angle1 != angle2;
    }

    float [] orderedAngles(Triangle t){
        /*This function orders the angles of the triangle by creating an array and using
        * the sorting method.*/
        float[] arr = new float[3];
        arr[0] = t.angle0; arr[1] = t.angle1; arr[2] = t.angle2;

        Arrays.sort(arr);

        return arr;
    }

    @Override
    public boolean equals ( Object o ) {

        if(this == o){
            return true;
        }
        if(o == null){
            return false;
        }

        if(this.getClass() != o.getClass()){
            return false;
        }

        Triangle triangle = (Triangle) o;

        float [] arr1 = orderedAngles(triangle);
        float [] arr2 = orderedAngles(this);

        /*Once the angles are sorted both triangle angles are compared*/

        return arr1[0] == arr2[0] && arr1[1] == arr2[1] && arr1[2] == arr2[2];

    }

    @Override
    public int hashCode () {
        float []arr = orderedAngles(this);
         /* Once the angles are ordered we calculate the hashcode result */
        int result = (int) arr[0];
        result = 31 * result + (int) arr[1];
        result = 31 * result + (int) arr[2];

        return result;
    }
}
