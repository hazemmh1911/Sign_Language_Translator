#include "Talkie.h"
#include <Wire.h>
#include "Vocab_US_Large.h"
#include "Vocab_Special.h"
#include "I2Cdev.h"
#include "Adafruit_GFX.h"
#include "Adafruit_SSD1331.h"
#include "Privet_defiens.h"
Talkie voice;

Adafruit_SSD1331 display = Adafruit_SSD1331(cs, dc, mosi, sclk, rst);

char MODE =None;

// ================================================================
// ===                         SETUP                            ===
// ================================================================
void setup()
{
// ================================================================
// ===                      MPU6050 SETUP                       ===
// ================================================================
  Wire.begin();
  Wire.beginTransmission(MPU_addr);  //Start communicating with the MPU-6050
  Wire.write(0x6B);                 //Send the requested starting register  // PWR_MGMT_1 register
  Wire.write(0);                   //Set the requested starting register
  Wire.endTransmission(true);     //End the transmission
  Serial.begin(9600);
  
// ================================================================
// ===                       OLED SETUP                         ===
// ================================================================
  display.begin();
  
// ================================================================
// ===                        SWITCHES                          ===
// ================================================================
  pinMode(Numbers_swt,   INPUT);
  pinMode(E_Letters_swt, INPUT);
  pinMode(E_Words_swt,   INPUT);
  pinMode(A_Letters_swt, INPUT);
  pinMode(A_Words_swt,   INPUT);
}

// ================================================================
// ===                        MAIN LOOP                         ===
// ================================================================
void loop()
{
  int Num_Reading       =digitalRead(Numbers_swt);
  int E_Letters_Reading =digitalRead(E_Letters_swt);
  int E_Words_Reading   =digitalRead(E_Words_swt);
  int A_Letters_Reading =digitalRead(A_Letters_swt);
  int A_Words_Reading   =digitalRead(A_Words_swt);
// ================================================================
// ===                     MODE SELECTION                       ===
// ================================================================
  if      (Numbers_Mode)
           MODE=Numbers;
           
  else if (E_Letters_Mode)
           MODE=E_Letters;
           
  else if (E_Words_Mode)
           MODE=E_Words;
           
  else if (A_Letters_Mode)
           MODE=A_Letters;
           
  else if (A_Words_Mode)
           MODE=A_Words;
            
// ================================================================
// ===                      FLEX READINGS                       ===
// ================================================================
  thumb_reading = analogRead(thumb);
  index_reading = analogRead(index);
  mid_reading   = analogRead(mid);
  ring_reading  = analogRead(ring);
  pinky_reading = analogRead(pinky);

// ================================================================
// ===                   MPU6050 READINGS                       ===
// ================================================================
  Wire.beginTransmission(MPU_addr);
  Wire.write(0x3B);
  Wire.endTransmission(false);
  Wire.requestFrom(MPU_addr, 14, true);
  AcX = Wire.read() << 8 | Wire.read();
  AcY = Wire.read() << 8 | Wire.read();
  AcZ = Wire.read() << 8 | Wire.read();
  int xAng = map(AcX, minVal, maxVal, -90, 90);
  int yAng = map(AcY, minVal, maxVal, -90, 90);
  int zAng = map(AcZ, minVal, maxVal, -90, 90);
  x = RAD_TO_DEG * (atan2(-yAng, -zAng) + PI);
  y = RAD_TO_DEG * (atan2(-xAng, -zAng) + PI);
  z = RAD_TO_DEG * (atan2(-yAng, -xAng) + PI);

// ================================================================
// ===                  OLED SCREEN CLEAR                       ===
// ================================================================
 display.begin();
 display.fillScreen(BLACK);
 display.setCursor(0, 5);
 display.setTextColor(BLUE);
 display.setTextSize(1.5);
 
// ================================================================
// ===                     NUMBERS OUTPUT                       ===
// ================================================================
 if (MODE==Numbers)
  {   
    display.print("MODE:Numbers");
    display.setTextColor(WHITE);
    display.setTextSize(3);
    display.setCursor(35, 30);
  
                    if       (Zero)
                    {
                      Serial.print("0");
                      Serial.print("\n");
                      display.print("0");
                      voice.say(spZERO);
                      delay(1000);
                    }
                    
                    else if  (One) 
                    {
                      Serial.print("1");
                      Serial.print("\n");
                      display.print("1");
                      voice.say(spONE);
                      delay(1000);
                    }
                  
                    else if  (Two)
                    {
                      Serial.print("2");
                      Serial.print("\n");
                      display.print("2");
                      voice.say(spTWO);
                      delay(1000);
                    }
                  
                    else if  (Three)
                    {
                      Serial.print("3");
                      Serial.print("\n");
                      display.print("3");
                      voice.say(spTHREE);
                      delay(1000);
                    }
                  
                    else if   (Four)
                    {
                      Serial.print("4");
                      Serial.print("\n");
                      display.print("4");
                      voice.say(spFOUR);
                      
                      delay(1000);
                    }
               
                    else if   (Five)
                    {
                      Serial.print("5");
                      Serial.print("\n");
                      display.print("5");
                      voice.say(spFIVE);
                      delay(1000);
                    }
                  
                    else if   (Six)
                    {
                      Serial.print("6");
                      Serial.print("\n");
                      display.print("6");
                      voice.say(spSIX);
                      delay(1000);
                    }
                  
                    else if   (Seven)
                    {
                      Serial.print("7");
                      Serial.print("\n");
                      display.print("7");
                      voice.say(spSEVEN);
                      delay(1000);
                    }
                  
                    else if  (Eight)
                    {
                      Serial.print("8");
                      Serial.print("\n");
                      display.print("8");
                      voice.say(spEIGHT); 
                      delay(1000);
                    }
                  
                    else if (Nine)
                    {
                      Serial.print("9");
                      Serial.print("\n");
                      display.print("9");
                      voice.say(spNINE);
                      delay(1000);
                    }
  }


// ================================================================
// ===                 ENGLISH LETTERS OUTPUT                   ===
// ================================================================
else if(MODE==E_Letters)
  {
    display.print("MODE:English Letters");
    display.setTextColor(WHITE);
    display.setTextSize(3);
    display.setCursor(35, 30);
    
            if (CharA) 
            {
              Serial.print("A");
              Serial.print("\n");
              display.print("A");
              voice.say(spA);
              delay(1000);
            }
            
            else if (CharB) 
            {
              Serial.print("B");
              Serial.print("\n");
              display.print("B");
              voice.say(spB);
              delay(1000);
            }
            
            else if (CharC) {
              Serial.print("C");
              Serial.print("\n");
              display.print("C");
              voice.say(spC);
              delay(1000);
            }

            else if (CharD)
            {
              Serial.print("D");
              Serial.print("\n");
              display.print("D");
              voice.say(spD);
              delay(1000);
            }
            
            else if (CharE) 
            {
              Serial.print("E");
              Serial.print("\n");
              display.print("E");
              voice.say(spE);
              delay(1000);
            }

            else if (CharF)
            {
              Serial.print("F");
              Serial.print("\n");
              display.print("F");
              voice.say(spF);
              delay(1000);
            }
            
            else if (CharG) 
            {
              Serial.print("G");
              Serial.print("\n");
              display.print("G");
              voice.say(spG);
              delay(1000);              
            }
            
            else if (CharH) 
            {
              Serial.print("H");
              Serial.print("\n");
              display.print("H");
              voice.say(spH);
              delay(1000);          
            }
            
            else if (CharI)
            {
              Serial.print("I");
              Serial.print("\n");
              display.print("I");
              voice.say(spI);
              delay(1000);         
            }
            
            else if (CharJ)
            {
              Serial.print("J");
              Serial.print("\n");
              display.print("J");
              voice.say(spJ);
              delay(1000);
            }
            
            else if (CharK) 
            {
              Serial.print("K");
              Serial.print("\n");
              display.print("K");
              voice.say(spK);
              delay(1000);
            }
            
            else if (CharL) 
            {
              Serial.print("L");   
              Serial.print("\n");           
              display.print("L");
              voice.say(spL);
              delay(1000);
            }
            
            else if (CharM) 
            {
              Serial.print("M");
              Serial.print("\n");
              display.print("M");
              voice.say(spM);
              delay(1000);          
            }
            
            else if (CharN)
            {
              Serial.print("N");    
              Serial.print("\n");         
              display.print("N");
              voice.say(spN);
              delay(1000);          
            }
            
            else if (CharO) 
            {
              Serial.print("O");   
              Serial.print("\n");           
              display.print("O");
              voice.say(spO);
              delay(1000);          
            }
            
            else if (CharP)
            {
              Serial.print("P"); 
              Serial.print("\n");             
              display.print("P");
              voice.say(spP);
              delay(1000);          
            }
            
            else if (CharQ)
            {
              Serial.print("Q"); 
              Serial.print("\n");            
              display.print("Q");
              voice.say(spQ);
              delay(1000);          
            }
            
            else if (CharR) 
            {
              Serial.print("R");
              Serial.print("\n");              
              display.print("R");
              voice.say(spR);
              delay(1000);          
            }
            
            else if (CharS) 
            {
              Serial.print("S");   
              Serial.print("\n");           
              display.print("S");
              voice.say(spS);
              delay(1000);        
            }
            
            else if (CharT) 
            {
              Serial.print("T");     
              Serial.print("\n");         
              display.print("T");
              voice.say(spT);
              delay(1000);
            }
            
            else if (CharU)
            {
              Serial.print("U");  
              Serial.print("\n");            
              display.print("U");
              voice.say(spU);
              delay(1000);
            }
            
            else if (CharV) 
            {
              Serial.print("V");  
              Serial.print("\n");           
              display.print("V");
              voice.say(spV);
              delay(1000);
            }
            
            else if (CharW)
            {
              Serial.print("W");
              Serial.print("\n");
              display.print("W");
              voice.say(spW);
              delay(1000);
            }
            
            else if (CharX)
            {
              Serial.print("X");   
              Serial.print("\n");         
              display.print("X");
              voice.say(spX);
              delay(1000);
            }
            
            else if (CharY) 
            {
              Serial.print("Y");    
              Serial.print("\n");          
              display.print("Y");
              voice.say(spY);
              delay(1000);
            }
            
            else if (CharZ) 
            {
              Serial.print("Z");    
              Serial.print("\n");         
              display.print("Z");
              voice.say(spZ);
              delay(1000);
            }
  }


// ================================================================
// ===                 ARABIC LETTERS OUTPUT                   ===
// ================================================================
else if (MODE==A_Letters)
  {
    display.print("MODE:Arabic Letters");
            if (AChar_ALF) 
            {
              Serial.print("ALF");
              Serial.print("\n");
              delay(1000);
              //أ//
            }
            
            else if (AChar_BAA) 
            {
              Serial.print("BAA");
              Serial.print("\n");
              delay(1000);
              //ب//
            }
            
            else if (AChar_TAA)
            {
              Serial.print("TAA");
              Serial.print("\n");
              delay(1000);
              //ت//
            }
            
            else if (AChar_THA)
            {
              Serial.print("THA");
              Serial.print("\n");
              delay(1000);
              //ث//
            }
            
            else if (AChar_GEM)
            {
              Serial.print("GEM");
              Serial.print("\n");
              delay(1000);
              //ج//
            }
            
            else if (AChar_HAA) 
            {
              Serial.print("HAA");
              Serial.print("\n");
              delay(1000);
              //ح//
            }
            
            else if (AChar_KHA)
            {
              Serial.print("KHA");
              Serial.print("\n");
              delay(1000);
              //خ//
            }
            
            else if (AChar_DAL) 
            {
              Serial.print("DAL");
              Serial.print("\n");
              delay(1000);
              //د//
            }
            
            else if (AChar_ZAL) 
            {
              Serial.print("ZAL");
              Serial.print("\n");
              delay(1000);
              //ذ//
            }
            
            else if (AChar_RAA) 
            {
              Serial.print("RAA");
              Serial.print("\n");
              delay(1000);
              //ر//
            }
            
            else if (AChar_ZAY) 
            {
              Serial.print("ZAY");
              Serial.print("\n");
              delay(1000);
              //ز//
            }
            
            else if (AChar_SEN)
            {
              Serial.print("SEN");
              Serial.print("\n");
              delay(1000);
              //س//
            }
            
            else if (AChar_SHN)
            {
              Serial.print("SHN");
              Serial.print("\n");
              delay(1000);
              //ش//
            }
            
            else if (AChar_SAD) 
            {
              Serial.print("SAD");
              Serial.print("\n");
              delay(1000);
              //ص//
            }
            
            else if (AChar_DAD) 
            {
              Serial.print("DAD");
              Serial.print("\n");
              delay(1000);
              //ض//
            }
            
            else if (AChar_TA) 
            {
              Serial.print("TA");
              Serial.print("\n");
              delay(1000);
              //ط//
            }
            
            else if (AChar_ZA)
            {
              Serial.print("ZA");
              Serial.print("\n");
              delay(1000);
              //ظ//
            }
            
            else if (AChar_EEN) 
            {
              Serial.print("EEN");
              Serial.print("\n");
              delay(1000);
              //ع//
            }
            
            else if (AChar_GEN)
            {
              Serial.print("GEN");
              Serial.print("\n");
              delay(1000);
              //غ//
            }
            
            else if (AChar_FAA)
            {
              Serial.print("FAA");
              Serial.print("\n");
              delay(1000);
              //ف//
            }
            
            else if (AChar_QAF)
            {
              Serial.print("QAF");
              Serial.print("\n");
              delay(1000);
              //ق//
            }
            
            else if (AChar_KAF))
            {
              Serial.print("KAF");
              Serial.print("\n");
              delay(1000);
              //ك//
            }
            
            else if (AChar_LAM)
            {
            Serial.print("LAM");
            Serial.print("\n");
            delay(1000);
              //ل//
            }
            
            else if (AChar_MEM) 
            {
            Serial.print("MEM");
            Serial.print("\n");
            delay(1000);
              //م//
            }
            
            else if (AChar_NON)
            {
            Serial.print("NON");
            Serial.print("\n");
            delay(1000);
              //ن//
            }
            
            else if (AChar_HA)
            {
            Serial.print("HA");
            Serial.print("\n");
            delay(1000);
              //ه//
            }
            
            else if (AChar_WAW) 
            {
            Serial.print("WAW");
            Serial.print("\n");
            delay(1000);
              //و//
            }
            
            else if (AChar_YAA)
            {
            Serial.print("YAA");
            Serial.print("\n");
            delay(1000);
              //ي//
            }
            
  }

// ================================================================
// ===                  ENGLISH WORDS OUTPUT                    ===
// ================================================================
else if (MODE==E_Words){
  display.print("MODE:English Words");

            if (HELLO) 
            {
              Serial.print("HELLO");
              Serial.print("\n");
              display.print("HELLO");
              delay(1000);
            }
            
            else if (YES) 
            {
              Serial.print("YES");
              Serial.print("\n");
              display.print("YES");
              delay(1000);
            }
            
            else if (NO) 
            {
              Serial.print("NO");
              Serial.print("\n");
              display.print("NO");
              delay(1000);
            }
  }

// ================================================================
// ===                   ARABIC WORDS OUTPUT                    ===
// ================================================================
else if(MODE==A_Words){
  display.print("MODE:Arabic Words");

            if (A_HELLO) 
            {
              Serial.print("A_HELLO");
              Serial.print("\n");
              display.print("HELLO");
              delay(1000);
            }
            
            else if (A_YES) 
            {
              Serial.print("A_YES");
              Serial.print("\n");
              display.print("YES");
              delay(1000);
            }
            
            else if (A_NO) 
            {
              Serial.print("A_NO");
              Serial.print("\n");
              display.print("NO");
              delay(1000);
            }
  } 
}
