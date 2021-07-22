import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.serial.*; 
import processing.sound.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Final_Form extends PApplet {




Serial mySerial; 
String myString;
String myVal;

// ===================================================
// ===               NUMBERS VARIABLES             ===
// ===================================================
SoundFile Zero;
SoundFile One;
SoundFile Two;
SoundFile Three;
SoundFile Four;
SoundFile Five;
SoundFile Six;
SoundFile Seven;
SoundFile Eight;
SoundFile Nine;

// ===================================================
// ===          ENGLISH LETTERS VARIABLES          ===
// ===================================================
SoundFile A;
SoundFile B;
SoundFile C;
SoundFile D;
SoundFile E;
SoundFile F;
SoundFile G;
SoundFile H;
SoundFile I;
SoundFile J;
SoundFile K;
SoundFile L;
SoundFile M;
SoundFile N;
SoundFile O;
SoundFile P;
SoundFile Q;
SoundFile R;
SoundFile S;
SoundFile T;
SoundFile U;
SoundFile V;
SoundFile W;
SoundFile X;
SoundFile Y;
SoundFile Z;

// ===================================================
// ===          ARABIC LETTERS VARIABLES           ===
// ===================================================
SoundFile ALF;
SoundFile BAA;
SoundFile TAA;
SoundFile THA;
SoundFile GEM;
SoundFile HAA;
SoundFile KHA;
SoundFile DAL;
SoundFile ZAL;
SoundFile RAA;
SoundFile ZAY;
SoundFile SEN;
SoundFile SHN;
SoundFile SAD;
SoundFile DAD;
SoundFile TA;
SoundFile ZA;
SoundFile EEN;
SoundFile GEN;
SoundFile FAA;
SoundFile QAF;
SoundFile KAF;
SoundFile LAM;
SoundFile MEM;
SoundFile NON;
SoundFile HA;
SoundFile WAW;
SoundFile YAA;

// ===================================================
// ===            ENGLISH WORDS VARIABLES          ===
// ===================================================
SoundFile HELLO;
SoundFile YES;
SoundFile NO;

// ===================================================
// ===            ARABIC WORDS VARIABLES           ===
// ===================================================
SoundFile A_HELLO;
SoundFile A_YES;
SoundFile A_NO;

// ===================================================
// ===             APPLICATION SETUP               ===
// ===================================================
public void setup() 
{

   //APP SIZE DECLERATION 
  
  mySerial =new Serial(this, "COM6", 9600); //SERIAL PORT DECLERATION
  
// ===================================================
// ===             NUMBERS DECLERATION             ===
// ===================================================
  Zero  = new SoundFile(this,"Zero.mp3");
  One   = new SoundFile(this,"One.mp3");
  Two   = new SoundFile(this,"Two.mp3");
  Three = new SoundFile(this,"Three.mp3");
  Four  = new SoundFile(this,"Four.mp3");
  Five  = new SoundFile(this,"Five.mp3");
  Six   = new SoundFile(this,"Six.mp3");
  Seven = new SoundFile(this,"Seven.mp3");
  Eight = new SoundFile(this,"Eight.mp3");
  Nine  = new SoundFile(this,"Nine.mp3");
  
// ===================================================
// ===         ENGLISH LETTERS DECLERATION         ===
// ===================================================
  A = new SoundFile(this,"A.mp3");
  B = new SoundFile(this,"B.mp3");
  C = new SoundFile(this,"C.mp3");
  D = new SoundFile(this,"D.mp3");
  E = new SoundFile(this,"E.mp3");
  F = new SoundFile(this,"F.mp3");
  G = new SoundFile(this,"G.mp3");
  H = new SoundFile(this,"H.mp3");
  I = new SoundFile(this,"I.mp3");
  J = new SoundFile(this,"J.mp3");
  K = new SoundFile(this,"K.mp3");
  L = new SoundFile(this,"L.mp3");
  M = new SoundFile(this,"M.mp3");
  N = new SoundFile(this,"N.mp3");
  O = new SoundFile(this,"O.mp3");
  P = new SoundFile(this,"P.mp3");
  Q = new SoundFile(this,"Q.mp3");
  R = new SoundFile(this,"R.mp3");
  S = new SoundFile(this,"S.mp3");
  T = new SoundFile(this,"T.mp3");
  U = new SoundFile(this,"U.mp3");
  V = new SoundFile(this,"V.mp3");
  W = new SoundFile(this,"W.mp3");
  X = new SoundFile(this,"X.mp3");
  Y = new SoundFile(this,"Y.mp3");
  Z = new SoundFile(this,"Z.mp3");

// ===================================================
// ===         ARABIC LETTERS DECLERATION          ===
// ===================================================
  ALF = new SoundFile(this,"ALF.mp3");
  BAA = new SoundFile(this,"BAA.mp3");
  TAA = new SoundFile(this,"TAA.mp3");
  THA = new SoundFile(this,"THA.mp3");
  GEM = new SoundFile(this,"GEM.mp3");
  HAA = new SoundFile(this,"HAA.mp3");
  KHA = new SoundFile(this,"KHA.mp3");
  DAL = new SoundFile(this,"DAL.mp3");
  ZAL = new SoundFile(this,"ZAL.mp3");
  RAA = new SoundFile(this,"RAA.mp3");
  ZAY = new SoundFile(this,"ZAY.mp3");
  SEN = new SoundFile(this,"SEN.mp3");
  SHN = new SoundFile(this,"SHN.mp3");
  SAD = new SoundFile(this,"SAD.mp3");
  DAD = new SoundFile(this,"DAD.mp3");
  TA  = new SoundFile(this,"TA.mp3");
  ZA  = new SoundFile(this,"ZA.mp3");
  EEN = new SoundFile(this,"EEN.mp3");
  GEN = new SoundFile(this,"GEN.mp3");
  FAA = new SoundFile(this,"FAA.mp3");
  QAF = new SoundFile(this,"QAF.mp3");
  KAF = new SoundFile(this,"KAF.mp3");
  LAM = new SoundFile(this,"LAM.mp3");
  MEM = new SoundFile(this,"MEM.mp3");
  NON = new SoundFile(this,"NON.mp3");
  HA  = new SoundFile(this,"HA.mp3");
  WAW = new SoundFile(this,"WAW.mp3");
  YAA = new SoundFile(this,"YAA.mp3");
  
// ===================================================
// ===          ENGLISH WORDS DECLERATION          ===
// ===================================================
  HELLO = new SoundFile(this,"HELLO.mp3");
  YES   = new SoundFile(this,"YES.mp3");
  NO    = new SoundFile(this,"NO.mp3");
  
// ===================================================
// ===           ARABIC WORDS DECLERATION          ===
// ===================================================
  A_HELLO = new SoundFile(this,"A_HELLO.wav");
  A_YES   = new SoundFile(this,"A_YES.wav");
  A_NO    = new SoundFile(this,"A_NO.wav");
}

public void draw()
{
  
  while (mySerial.available() > 0)            //SERIAL PORT AVAILABILITY CHECK
  {
    
  myString = mySerial.readStringUntil(10);    // 10 is the ASCII fo \n 
   
  if (myString !=null)                        //DATA AVAILABILITY CHECK
    {
       myVal = myString;
       background(0);
       textSize(35);
       text("Move your hand to detect the sign", 50, 100);
     
// ===================================================
// ===                NUMBERS CHECK                ===
// ===================================================

     if (myVal.equals("0\n") == true)
      {
        text("Current mood:Numbers ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("0",345,345);
        Zero.play();
      }
      
     else if (myVal.equals("1\n") == true)
      {
        text("Current mood:Numbers ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("1",345,345);
        One.play();
      }
      
    else if (myVal.equals("2\n") == true)
      {
        text("Current mood:Numbers ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("2",345,345);
        Two.play();
      }
      
    else if (myVal.equals("3\n") == true)
      {
        text("Current mood:Numbers ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("3",345,345);
        Three.play();
      }
      
    else if (myVal.equals("4\n") == true)
      {
        text("Current mood:Numbers ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("4",345,345);
        Four.play();
      }
      
    else if (myVal.equals("5\n") == true)
      {
        text("Current mood:Numbers ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("5",345,345);
        Five.play();
      }
      
    else if (myVal.equals("6\n") == true)
      {
        text("Current mood:Numbers ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("6",345,345);
        Six.play();
      }
      
    else if (myVal.equals("7\n") == true)
      {
        text("Current mood:Numbers ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("7",345,345);
        Seven.play();
      }
      
    else if (myVal.equals("8\n") == true)
      {
        text("Current mood:Numbers ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("8",345,345);
        Eight.play();
      }
      
    else if (myVal.equals("9\n") == true)
      {
        text("Current mood:Numbers ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("9",345,345);
        Nine.play();
      }

// ===================================================
// ===           ENGLISH LETTERS CHECK             ===
// ===================================================

    if (myVal.equals("A\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("A",345,345);
        A.play();
      }
      
    else if (myVal.equals("B\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("B",345,345);
        B.play();
      }
      
    else if (myVal.equals("C\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("C",345,345);
        C.play();
      }
      
    else if (myVal.equals("D\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("D",345,345);
        D.play();
      }
      
    else if (myVal.equals("E\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50); 
        text("E",345,345);
        E.play();
      }
      
    else if (myVal.equals("F\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("F",345,345);
        F.play();
      }
      
    else if (myVal.equals("G\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("G",345,345);
        G.play();
      }
      
    else if (myVal.equals("H\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("H",345,345);
        H.play();
      }
      
    else if (myVal.equals("I\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("I",345,345);
        I.play();
      }
      
    else if (myVal.equals("J\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("J",345,345);
        J.play();
      }
      
    else if (myVal.equals("K\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("K",345,345);
        K.play();
      }
      
    else if (myVal.equals("L\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("L",345,345);
        L.play();
      }
      
    else if (myVal.equals("M\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("M",345,345);
        M.play();
      } 
      
    else if (myVal.equals("N\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("N",345,345);
        N.play();
      }
      
    else if (myVal.equals("O\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("O",345,345);
        O.play();
      }
      
    else if (myVal.equals("P\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("P",345,345);
        P.play();
      }
      
    else if (myVal.equals("Q\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("Q",345,345);
        Q.play();
      }
      
    else if (myVal.equals("R\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("R",345,345);
        R.play();
      }
      
    else if (myVal.equals("S\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("S",345,345);
        S.play();
      }
      
    else if (myVal.equals("T\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("T",345,345);
        T.play();
      }
      
    else if (myVal.equals("U\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("U",345,345);
        U.play();
      }
      
    else if (myVal.equals("V\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("V",345,345);
        V.play();
      }
      
    else if (myVal.equals("W\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("W",345,345);
        W.play();
      }
      
    else if (myVal.equals("X\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("X",345,345);
        X.play();
      }
      
    else if (myVal.equals("Y\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("Y",345,345);
        Y.play();
      }
      
    else if (myVal.equals("Z\n") == true)
      {
        text("Current mood:English Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("Z",345,345);
        Z.play();
      }
      
// ===================================================
// ===            ARABIC LETTERS CHECK             ===
// ===================================================

    if (myVal.equals("ALF\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("ا",345,345);
        ALF.play();
      }
      
    else if (myVal.equals("BAA\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("ب",345,345);
        BAA.play();
      }
      
    else if (myVal.equals("TAA\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("ت",345,345);
        TAA.play();
      }
      
    else if (myVal.equals("THA\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("ث",345,345);
        THA.play();
      }
      
    else if (myVal.equals("GEM\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50); 
        text("ج",345,345);
        GEM.play();
      }
      
    else if (myVal.equals("HAA\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("ح",345,345);
        HAA.play();
      }
      
    else if (myVal.equals("KHA\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("خ",345,345);
        KHA.play();
      }
      
    else if (myVal.equals("DAL\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("د",345,345);
        DAL.play();
      }
      
    else if (myVal.equals("ZAL\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("ذ",345,345);
        ZAL.play();
      }
      
    else if (myVal.equals("RAA\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("ر",345,345);
        RAA.play();
      }
      
    else if (myVal.equals("ZAY\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("ز",345,345);
        ZAY.play();
      }
      
    else if (myVal.equals("SEN\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("س",345,345);
        SEN.play();
      }
      
    else if (myVal.equals("SHN\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("ش",345,345);
        SHN.play();
      } 
      
    else if (myVal.equals("SAD\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("ص",345,345);
        SAD.play();
      }
      
    else if (myVal.equals("DAD\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("ض",345,345);
        DAD.play();
      }
      
    else if (myVal.equals("TA\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("ط",345,345);
        TA.play();
      }
      
    else if (myVal.equals("ZA\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("ظ",345,345);
        ZA.play();
      }
      
    else if (myVal.equals("EEN\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("ع",345,345);
        EEN.play();
      }
      
    else if (myVal.equals("GEN\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("غ",345,345);
        GEN.play();
      }
      
    else if (myVal.equals("FAA\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("ف",345,345);
        FAA.play();
      }
      
    else if (myVal.equals("QAF\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("ق",345,345);
        QAF.play();
      }
      
    else if (myVal.equals("KAF\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("ك",345,345);
        KAF.play();
      }
      
    else if (myVal.equals("LAM\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("ل",345,345);
        LAM.play();
      }
      
    else if (myVal.equals("MEM\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("م",345,345);
        MEM.play();
      }
      
    else if (myVal.equals("NON\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("ن",345,345);
        NON.play();
      }
      
    else if (myVal.equals("HA\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("ه",345,345);
        HA.play();
      }
      
    else if (myVal.equals("WAW\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("و",345,345);
        WAW.play();
      }
      
    else if (myVal.equals("YAA\n") == true)
      {
        text("Current mood:Arabic Letters ",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("ي",345,345);
        YAA.play();
      }

// ===================================================
// ===             ENGLSH WORDS CHECK              ===
// ===================================================

     if (myVal.equals("HELLO\n") == true)
      {
        text("Current mood:English Words",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("HELLO",345,345);
        HELLO.play();
      }
      
     else if (myVal.equals("YES\n") == true)
      {
        text("Current mood:English Words",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("YES",345,345);
        YES.play();
      }
      
    else if (myVal.equals("NO\n") == true)
      {
        text("Current mood:English Words",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("NO",345,345);
        NO.play();
      }

// ===================================================
// ===             ARABIC WORDS CHECK              ===
// ===================================================

     if (myVal.equals("A_HELLO\n") == true)
      {
        text("Current mood:Arabic Words",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("مرحبا",345,345);
        A_HELLO.play();
      }
      
     else if (myVal.equals("A_YES\n") == true)
      {
        text("Current mood:Arabic Words",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("نعم",345,345);
        A_YES.play();
      }
      
    else if (myVal.equals("A_NO\n") == true)
      {
        text("Current mood:Arabic Words",50, 150);
        text("Your Sign:",50, 200);
        textSize(50);
        text("لا",345,345);
        A_NO.play();
      }
    }
  }
}













  
  public void settings() {  size(720,720); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "Final_Form" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
