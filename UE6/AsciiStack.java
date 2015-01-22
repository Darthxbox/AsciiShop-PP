public class AsciiStack {

     AsciiImage[] imageArray;
    int index, anzahl;

    public AsciiStack(int index) {
        imageArray = new AsciiImage[index];
        this.index = index;
        this.anzahl = 0;
    }

    public int capacity() { return imageArray.length; }

    public int size() { return anzahl; }

    public boolean empty() { return anzahl == 0;}

    public AsciiImage peek() {

        if (anzahl == 0) return null;
        return imageArray[anzahl - 1];

    }

    public AsciiImage pop() {

        if (anzahl == 0) return null;

        AsciiImage ai;
        ai = imageArray[anzahl - 1];
        imageArray[anzahl - 1] = null;
        anzahl--;

        if ((imageArray.length - anzahl) > index) {
            AsciiImage[] helperImage = new AsciiImage[imageArray.length - index];
            for (int i = 0; i < helperImage.length; i++) {
                helperImage[i] = imageArray[i];
            }
            imageArray = helperImage;
        }
        return ai;
    }

    public void push(AsciiImage img) {
        if (imageArray.length < (anzahl + 1)) {
            AsciiImage[] tempImg = new AsciiImage[imageArray.length + index];
            for (int i = 0; i < imageArray.length; i++) {
                tempImg[i] = imageArray[i];
            }
            imageArray = tempImg;
        }
        imageArray[anzahl] = img;
        anzahl++;
    }




}
