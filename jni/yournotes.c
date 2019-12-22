#include "jni.h"
#include "stdlib.h"

JNIEXPORT jint JNICALL Java_id_ac_ui_cs_mobileprogramming_firandra_savitri_yournotes_FactsFragment_randomizer(JNIEnv* env, jobject obj)  {
    int n;
    n = rand() % 10;
    return n;
}