LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := yournotes
LOCAL_SRC_FILES := yournotes.c

include $(BUILD_SHARED_LIBRARY)