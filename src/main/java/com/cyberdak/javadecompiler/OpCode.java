package com.cyberdak.javadecompiler;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by 58 on 2016/12/29.
 */
public enum OpCode {
    nop((byte) 0x00, 0, "什么都不做。"),
    aconst_null((byte) 0x01, 0, "将 null 推送至栈顶。"),
    iconst_m1((byte) 0x02, 0, "将 int 型-1 推送至栈顶。"),
    iconst_0((byte) 0x03, 0, "将 int 型 0 推送至栈顶。"),
    iconst_1((byte) 0x04, 0, "将 int 型 1 推送至栈顶。"),
    iconst_2((byte) 0x05, 0, "将 int 型 2 推送至栈顶。"),
    iconst_3((byte) 0x06, 0, "将 int 型 3 推送至栈顶。"),
    iconst_4((byte) 0x07, 0, "将 int 型 4 推送至栈顶。"),
    iconst_5((byte) 0x08, 0, "将 int 型 5 推送至栈顶。"),
    lconst_0((byte) 0x09, 0, "将 long 型 0 推送至栈顶。"),
    lconst_1((byte) 0x0a, 0, "将 long 型 1 推送至栈顶。"),
    fconst_0((byte) 0x0b, 0, "将 float 型 0 推送至栈顶。"),
    fconst_1((byte) 0x0c, 0, "将 float 型 1 推送至栈顶。"),
    fconst_2((byte) 0x0d, 0, "将 float 型 2 推送至栈顶。"),
    dconst_0((byte) 0x0e, 0, "将 double 型 0 推送至栈顶。"),
    dconst_1((byte) 0x0f, 0, "将 double 型 1 推送至栈顶。"),
    bipush((byte) 0x10, 1, "将单字节的常量值（-128~127）推送至栈顶。"),
    sipush((byte) 0x11, 1, "将一个短整型常量值（-32768~32767）推送至栈顶。"),
    ldc((byte) 0x12, 1, "将 int，float 或 String 型常量值从常量池中推送至栈顶。"),
    ldc_w((byte) 0x13, 1, "将 int，float 或 String 型常量值从常量池中推送至栈顶（宽索引）。"),
    ldc2_w((byte) 0x14, 1, "将 long 或 double 型常量值从常量池中推送至栈顶（宽索引）。"),
    iload((byte) 0x15, 1, "将指定的 int 型局部变量推送至栈顶。"),
    lload((byte) 0x16, 1, "将指定的 long 型局部变量推送至栈顶。"),
    fload((byte) 0x17, 1, "将指定的 float 型局部变量推送至栈顶。"),
    dload((byte) 0x18, 1, "将指定的 double 型局部变量推送至栈顶。"),
    aload((byte) 0x19, 1, "将指定的引用类型局部变量推送至栈顶。"),
    iload_0((byte) 0x1a, 0, "将第一个 int 型局部变量推送至栈顶。"),
    iload_1((byte) 0x1b, 0, "将第二个 int 型局部变量推送至栈顶。"),
    iload_2((byte) 0x1c, 0, "将第三个 int 型局部变量推送至栈顶。"),
    iload_3((byte) 0x1d, 0, "将第四个 int 型局部变量推送至栈顶。"),
    lload_0((byte) 0x1e, 0, "将第一个 long 型局部变量推送至栈顶。"),
    lload_1((byte) 0x1f, 0, "将第二个 long 型局部变量推送至栈顶。"),
    lload_2((byte) 0x20, 0, "将第三个 long 型局部变量推送至栈顶。"),
    lload_3((byte) 0x21, 0, "将第四个 long 型局部变量推送至栈顶。"),
    fload_0((byte) 0x22, 0, "将第一个 float 型局部变量推送至栈顶。"),
    fload_1((byte) 0x23, 0, "将第二个 float 型局部变量推送至栈顶。"),
    fload_2((byte) 0x24, 0, "将第三个 float 型局部变量推送至栈顶"),
    fload_3((byte) 0x25, 0, "将第四个 float 型局部变量推送至栈顶。"),
    dload_0((byte) 0x26, 0, "将第一个 double 型局部变量推送至栈顶。"),
    dload_1((byte) 0x27, 0, "将第二个 double 型局部变量推送至栈顶。"),
    dload_2((byte) 0x28, 0, "将第三个 double 型局部变量推送至栈顶。"),
    dload_3((byte) 0x29, 0, "将第四个 double 型局部变量推送至栈顶。"),
    aload_0((byte) 0x2a, 0, "将第一个引用类型局部变量推送至栈顶。"),
    aload_1((byte) 0x2b, 0, "将第二个引用类型局部变量推送至栈顶。"),
    aload_2((byte) 0x2c, 0, "将第三个引用类型局部变量推送至栈顶。"),
    aload_3((byte) 0x2d, 0, "将第四个引用类型局部变量推送至栈顶。"),
    iaload((byte) 0x2e, 2, "将 int 型数组指定索引的值推送至栈顶。"),
    laload((byte) 0x2f, 2, "将 long 型数组指定索引的值推送至栈顶。"),
    faload((byte) 0x30, 2, "将 float 型数组指定索引的值推送至栈顶。"),
    daload((byte) 0x31, 2, "将 double 型数组指定索引的值推送至栈顶。"),
    aaload((byte) 0x32, 2, "将引用型数组指定索引的值推送至栈顶。"),
    baload((byte) 0x33, 2, "将 boolean 或 byte 型数组指定索引的值推送至栈顶。"),
    caload((byte) 0x34, 2, "将 char 型数组指定索引的值推送至栈顶。"),
    saload((byte) 0x35, 2, "将 short 型数组指定索引的值推送至栈顶。"),
    istore((byte) 0x36, 1, "将栈顶 int 型数值存入指定局部变量。"),
    lstore((byte) 0x37, 1, "将栈顶 long 型数值存入指定局部变量。"),
    fstore((byte) 0x38, 1, "将栈顶 float 型数值存入指定局部变量。"),
    dstore((byte) 0x39, 1, "将栈顶 double 型数值存入指定局部变量。"),
    astore((byte) 0x3a, 1, "将栈顶引用型数值存入指定局部变量。"),
    istore_0((byte) 0x3b, 1, "将栈顶 int 型数值存入第一个局部变量。"),
    istore_1((byte) 0x3c,0, "将栈顶 int 型数值存入第二个局部变量。"),
    istore_2((byte) 0x3d,0, "将栈顶 int 型数值存入第三个局部变量。"),
    istore_3((byte) 0x3e,0, "将栈顶 int 型数值存入第四个局部变量。"),
    lstore_0((byte) 0x3f,0, "将栈顶 long 型数值存入第一个局部变量。"),
    lstore_1((byte) 0x40,0, "将栈顶 long 型数值存入第二个局部变量。"),
    lstore_2((byte) 0x41,0, "将栈顶 long 型数值存入第三个局部变量。"),
    lstore_3((byte) 0x42,0, "将栈顶 long 型数值存入第四个局部变量。"),
    fstore_0((byte) 0x43,0, "将栈顶 float 型数值存入第一个局部变量。"),
    fstore_1((byte) 0x44,0, "将栈顶 float 型数值存入第二个局部变量。"),
    fstore_2((byte) 0x45,0, "将栈顶 float 型数值存入第三个局部变量。"),
    fstore_3((byte) 0x46,0, "将栈顶 float 型数值存入第四个局部变量。"),
    dstore_0((byte) 0x47,0, "将栈顶 double 型数值存入第一个局部变量。"),
    dstore_1((byte) 0x48,0, "将栈顶 double 型数值存入第二个局部变量。"),
    dstore_2((byte) 0x49,0, "将栈顶 double 型数值存入第三个局部变量。"),
    dstore_3((byte) 0x4a,0, "将栈顶 double 型数值存入第四个局部变量。"),
    astore_0((byte) 0x4b,0, "将栈顶引用型数值存入第一个局部变量。"),
    astore_1((byte) 0x4c,0, "将栈顶引用型数值存入第二个局部变量。"),
    astore_2((byte) 0x4d,0, "将栈顶引用型数值存入第三个局部变量"),
    astore_3((byte) 0x4e,0, "将栈顶引用型数值存入第四个局部变量。"),
    iastore((byte) 0x4f,0, "将栈顶 int 型数值存入指定数组的指定索引位置"),
    lastore((byte) 0x50,0,  "将栈顶 long 型数值存入指定数组的指定索引位置。"),
    fastore((byte) 0x51,0,  "将栈顶 float 型数值存入指定数组的指定索引位置。"),
    dastore((byte) 0x52,0,  "将栈顶 double 型数值存入指定数组的指定索引位置。"),
    aastore((byte) 0x53,0,  "将栈顶引用型数值存入指定数组的指定索引位置。"),
    bastore((byte) 0x54,0,  "将栈顶 boolean 或 byte 型数值存入指定数组的指定索引位置。"),
    castore((byte) 0x55,0,  "将栈顶 char 型数值存入指定数组的指定索引位置"),
    sastore((byte) 0x56,0,  "将栈顶 short 型数值存入指定数组的指定索引位置。"),
    pop((byte) 0x57, 0,"将栈顶数值弹出（数值不能是 long 或 double 类型的）。"),
    pop2((byte) 0x58,0, "将栈顶的一个（long 或 double 类型的）或两个数值弹出（其它）。"),
    dup((byte) 0x59,0, "复制栈顶数值并将复制值压入栈顶。"),
    dup_x1((byte) 0x5a,0, "复制栈顶数值并将两个复制值压入栈顶。"),
    dup_x2((byte) 0x5b, 0,"复制栈顶数值并将三个（或两个）复制值压入栈顶。"),
    dup2((byte) 0x5c, 0,"复制栈顶一个（long 或 double 类型的)或两个（其它）数值并将复制值压入栈顶。"),
    dup2_x1((byte) 0x5d,0, "dup_x1 指令的双倍版本。"),
    dup2_x2((byte) 0x5e,0, "dup_x2 指令的双倍版本。"),
    swap((byte) 0x5f,0, "将栈最顶端的两个数值互换（数值不能是 long 或 double 类型的）。"),
    iadd((byte) 0x60, 0, "将栈顶两 int 型数值相加并将结果压入栈顶。"),
    ladd((byte) 0x61, 0, "将栈顶两 long 型数值相加并将结果压入栈顶。"),
    fadd((byte) 0x62, 0, "将栈顶两 float 型数值相加并将结果压入栈顶。"),
    dadd((byte) 0x63, 0, "将栈顶两 double 型数值相加并将结果压入栈顶。"),
    isub((byte) 0x64, 0, "将栈顶两 int 型数值相减并将结果压入栈顶。"),
    lsub((byte) 0x65, 0, "将栈顶两 long 型数值相减并将结果压入栈顶。"),
    fsub((byte) 0x66, 0, "将栈顶两 float 型数值相减并将结果压入栈顶。"),
    dsub((byte) 0x67, 0, "将栈顶两 double 型数值相减并将结果压入栈顶。"),
    imul((byte) 0x68, 0, "将栈顶两 int 型数值相乘并将结果压入栈顶。。"),
    lmul((byte) 0x69, 0, "将栈顶两 long 型数值相乘并将结果压入栈顶。"),
    fmul((byte) 0x6a, 0, "将栈顶两 float 型数值相乘并将结果压入栈顶。"),
    dmul((byte) 0x6b, 0, "将栈顶两 double 型数值相乘并将结果压入栈顶。"),
    idiv((byte) 0x6c, 0, "将栈顶两 int 型数值相除并将结果压入栈顶。"),
    ldiv((byte) 0x6d, 0, "将栈顶两 long 型数值相除并将结果压入栈顶。"),
    fdiv((byte) 0x6e, 0, "将栈顶两 float 型数值相除并将结果压入栈顶。"),
    ddiv((byte) 0x6f, 0, "将栈顶两 double 型数值相除并将结果压入栈顶。"),
    irem((byte) 0x70, 0, "将栈顶两 int 型数值作取模运算并将结果压入栈顶。"),
    lrem((byte) 0x71, 0, "将栈顶两 long 型数值作取模运算并将结果压入栈顶。"),
    frem((byte) 0x72, 0, "将栈顶两 float 型数值作取模运算并将结果压入栈顶。"),
    drem((byte) 0x73, 0, "将栈顶两 double 型数值作取模运算并将结果压入栈顶。"),
    ineg((byte) 0x74, 0, "将栈顶 int 型数值取负并将结果压入栈顶。"),
    lneg((byte) 0x75, 0, "将栈顶 long 型数值取负并将结果压入栈顶。"),
    fneg((byte) 0x76, 0, "将栈顶 float 型数值取负并将结果压入栈顶。"),
    dneg((byte) 0x77, 0, "将栈顶 double 型数值取负并将结果压入栈顶。"),
    ishl((byte) 0x78, 0, "将 int 型数值左移位指定位数并将结果压入栈顶。"),
    lshl((byte) 0x79, 0, "将 long 型数值左移位指定位数并将结果压入栈顶。"),
    ishr((byte) 0x7a, 0, "将 int 型数值右（有符号）移位指定位数并将结果压入栈顶。"),
    lshr((byte) 0x7b, 0, "将 long 型数值右（有符号）移位指定位数并将结果压入栈顶。"),
    iushr((byte) 0x7c, 0, "将 int 型数值右（无符号）移位指定位数并将结果压入栈顶。"),
    lushr((byte) 0x7d, 0, "将 long 型数值右（无符号）移位指定位数并将结果压入栈顶。"),
    iand((byte) 0x7e, 0, "将栈顶两 int 型数值作“按位与”并将结果压入栈顶。"),
    land((byte) 0x7f, 0, "将栈顶两 long 型数值作“按位与”并将结果压入栈顶。"),
    ior((byte) 0x80, 0, "将栈顶两 int 型数值作“按位或”并将结果压入栈顶。"),
    lor((byte) 0x81, 0, "将栈顶两 long 型数值作“按位或”并将结果压入栈顶。"),
    ixor((byte) 0x82, 0, "将栈顶两 int 型数值作“按位异或”并将结果压入栈顶。"),
    lxor((byte) 0x83, 0, "将栈顶两 long 型数值作“按位异或”并将结果压入栈顶。"),
    iinc((byte) 0x84, 0, "将指定 int 型变量增加指定值。"),
    i2l((byte) 0x85, 0, "将栈顶 int 型数值强制转换成 long 型数值并将结果压入栈顶。"),
    i2f((byte) 0x86, 0, "将栈顶 int 型数值强制转换成 float 型数值并将结果压入栈顶。"),
    i2d((byte) 0x87, 0, "将栈顶 int 型数值强制转换成 double 型数值并将结果压入栈顶。"),
    l2i((byte) 0x88, 0, "将栈顶 long 型数值强制转换成 int 型数值并将结果压入栈顶。"),
    l2f((byte) 0x89, 0, "将栈顶 long 型数值强制转换成 float 型数值并将结果压入栈顶。"),
    l2d((byte) 0x8a, 0, "将栈顶 long 型数值强制转换成 double 型数值并将结果压入栈顶。"),
    f2i((byte) 0x8b, 0, "将栈顶 float 型数值强制转换成 int 型数值并将结果压入栈顶。"),
    f2l((byte) 0x8c, 0, "将栈顶 float 型数值强制转换成 long 型数值并将结果压入栈顶。"),
    f2d((byte) 0x8d, 0, "将栈顶float型数值强制转换成double型数值并将结果压入栈顶。"),
    d2i((byte) 0x8e, 0, "将栈顶 double 型数值强制转换成 int 型数值并将结果压入栈顶。"),
    d2l((byte) 0x8f, 0, "将栈顶 double 型数值强制转换成 long 型数值并将结果压入栈顶。"),
    d2f((byte) 0x90, 0, "将栈顶double型数值强制转换成float型数值并将结果压入栈顶。"),
    i2b((byte) 0x91, 0, "将栈顶 int 型数值强制转换成 byte 型数值并将结果压入栈顶。"),
    i2c((byte) 0x92, 0, "将栈顶 int 型数值强制转换成 char 型数值并将结果压入栈顶。"),
    i2s((byte) 0x93, 0, "将栈顶 int 型数值强制转换成 short 型数值并将结果压入栈顶。"),
    lcmp((byte) 0x94, 0, "比较栈顶两 long 型数值大小，并将结果（1，0，-1）压入栈顶。"),
    fcmpl((byte) 0x95, 0, "比较栈顶两 float 型数值大小，并将结果（1，0，-1）压入栈顶；当其中一个数值为“NaN”时，将-1 压入栈顶。"),
    fcmpg((byte) 0x96, 0, "比较栈顶两 float 型数值大小，并将结果（1，0，-1）压入栈顶；当其中一个数值为“NaN”时，将 1 压入栈顶。"),
    dcmpl((byte) 0x97, 0, "比较栈顶两 double 型数值大小，并将结果（1，0，-1）压入栈顶；当其中一个数值为“NaN”时，将-1 压入栈顶。"),
    dcmpg((byte) 0x98, 0, "比较栈顶两 double 型数值大小，并将结果（1，0，-1）压入栈顶；当其中一个数值为“NaN”时，将 1 压入栈顶。"),
    ifeq((byte) 0x99, 2, "当栈顶 int 型数值等于 0 时跳转。"),
    ifne((byte) 0x9a, 2, "当栈顶 int 型数值不等于 0 时跳转。"),
    iflt((byte) 0x9b, 2, "当栈顶 int 型数值小于 0 时跳转。"),
    ifge((byte) 0x9c, 2, "当栈顶 int 型数值大于等于 0 时跳转。"),
    ifgt((byte) 0x9d, 2, "当栈顶 int 型数值大于 0 时跳转。"),
    ifle((byte) 0x9e, 2, "当栈顶 int 型数值小于等于 0 时跳转。"),
    if_icmpeq((byte) 0x9f, 2, "比较栈顶两 int 型数值大小，当结果等于 0 时跳转。"),
    if_icmpne((byte) 0xa0, 2, "比较栈顶两 int 型数值大小，当结果不等于 0 时跳转。"),
    if_icmplt((byte) 0xa1, 2, "比较栈顶两 int 型数值大小，当结果小于 0 时跳转。"),
    if_icmpge((byte) 0xa2, 2, "比较栈顶两 int 型数值大小，当结果大于等于 0 时跳转。"),
    if_icmpgt((byte) 0xa3, 2, "比较栈顶两 int 型数值大小，当结果大于 0 时跳转"),
    if_icmple((byte) 0xa4, 2, "比较栈顶两 int 型数值大小，当结果小于等于 0 时跳转。"),
    if_acmpeq((byte) 0xa5, 2, "比较栈顶两引用型数值，当结果相等时跳转。"),
    if_acmpne((byte) 0xa6, 2, "比较栈顶两引用型数值，当结果不相等时跳转。"),
    GOTO((byte) 0xa7, 2, "无条件跳转。"),
    jsr((byte) 0xa8, 2, "跳转至指定 16 位 offset 位置，并将 jsr 下一条指令地址压入栈顶。"),
    ret((byte) 0xa9,  2,"返回至局部变量指定的 index 的指令位置（一般与 jsr，jsr_w联合使用）。"),
    tableswitch((byte) 0xaa,999, "用于 switch 条件跳转，case 值连续（可变长度指令）。"),
    lookupswitch((byte) 0xab,999, "用于 switch 条件跳转，case 值不连续（可变长度指令）。"),
    ireturn((byte) 0xac, 0, "从当前方法返回 int。"),
    lreturn((byte) 0xad, 0, "从当前方法返回 long。"),
    freturn((byte) 0xae, 0, "从当前方法返回 float。"),
    dreturn((byte) 0xaf, 0, "从当前方法返回 double。"),
    areturn((byte) 0xb0, 0, "从当前方法返回对象引用。"),
    RETURN((byte) 0xb1, 0, "从当前方法返回 void。"),
    getstatic((byte) 0xb2, 2, "获取指定类的静态域，并将其值压入栈顶。"),
    putstatic((byte) 0xb3, 2, "为指定的类的静态域赋值。"),
    getfield((byte) 0xb4, 2, "获取指定类的实例域，并将其值压入栈顶。"),
    putfield((byte) 0xb5, 2, "为指定的类的实例域赋值。"),
    invokevirtual((byte) 0xb6, 2, "调用实例方法。"),
    invokespecial((byte) 0xb7, 2, "调用超类构造方法，实例初始化方法，私有方法。"),
    invokestatic((byte) 0xb8, 2, "调用静态方法。"),
    invokeinterface((byte) 0xb9, 2, "调用接口方法。"),
    invokedynamic((byte) 0xba, 2, "调用动态链接方法①。"),
    NEW((byte) 0xbb, 2, "创建一个对象，并将其引用值压入栈顶。"),
    newarray((byte) 0xbc, 2, "创建一个指定原始类型（如 int、float、char„„）的数组，并将其引用值压入栈顶。"),
    anewarray((byte) 0xbd, 2, "创建一个引用型（如类，接口，数组）的数组，并将其引用值压入栈顶。"),
    arraylength((byte) 0xbe, 2, "获得数组的长度值并压入栈顶。"),
    athrow((byte) 0xbf, 2, "将栈顶的异常抛出。"),
    checkcast((byte) 0xc0, 2, "检验类型转换，检验未通过将抛出 ClassCastException。"),
    INSTANCEOF((byte) 0xc1, 2, "检验对象是否是指定的类的实例，如果是将 1 压入栈顶，否则将 0 压入栈顶。"),
    monitorenter((byte) 0xc2, 2, "获得对象的 monitor，用于同步方法或同步块。"),
    monitorexit((byte) 0xc3, 2, "释放对象的 monitor，用于同步方法或同步块。"),
    wide((byte) 0xc4, 2, "扩展访问局部变量表的索引宽度。"),
    multianewarray((byte) 0xc5, 2, "创建指定类型和指定维度的多维数组（执行该指令时，操作栈中必须包含各维度的长度值），并将其引用值压入栈顶。"),
    ifnull((byte) 0xc6, 2, "为 null 时跳转。"),
    ifnonnull((byte) 0xc7, 2, "不为 null 时跳转。"),
    goto_w((byte) 0xc8, 2, "无条件跳转（宽索引）。"),
    jsr_w((byte) 0xc9, 2, "跳转至指定 32 位地址偏移量位置，并将 jsr_w 下一条指令地址压入栈顶。"),
    breakpoint((byte) 0xca, 2, "调试时的断点标志。"),
    impdep1((byte) 0xfe, 2, "用于在特定硬件中使用的语言后门。"),
    impdep1_1((byte) 0xff, 2, "用于在特定硬件中使用的语言后门。");


    public static Map<Byte, String> opcodeMap = Maps.newHashMap();

    static {
        for (OpCode opcode : OpCode.values()) {
            opcodeMap.put(opcode.getCode(), opcode.name());
        }
    }

    private Byte code;
    private String text;
    private int paramSize;

    OpCode(Byte code, int paramSize, String text) {
        this.code = code;
        this.text = text;
        this.paramSize = paramSize;
    }

    public Byte getCode() {
        return code;
    }

    public void setCode(Byte code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getParamSize() {
        return paramSize;
    }

    public void setParamSize(int paramSize) {
        this.paramSize = paramSize;
    }

}
