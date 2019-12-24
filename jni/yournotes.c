#include <stdio.h>
#include <stdlib.h>
#include <jni.h>

JNIEXPORT jint JNICALL Java_id_ac_ui_cs_mobileprogramming_firandra_1savitri_yournotes_FactsFragment_randomizer(JNIEnv* env, jobject obj)  {
    int n;
    n = rand() % 9;
    return n;
}