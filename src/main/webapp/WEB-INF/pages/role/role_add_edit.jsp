<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form class="layui-form" lay-filter="form_role_add_edit">
	<input class="layui-hide" name="rowId"/>
	<div class="layui-form-item">
		<label class="layui-form-label">角色类型</label>
		<div class="layui-input-block">
			<select name="roleKind" lay-verify="required">
				<option value=""></option>
				<option value="0">普通角色</option>
				<option value="1">超级角色</option>
			</select>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">角色名称</label>
		<div class="layui-input-block">
			<!-- lay-verify="required" 是校检 -->
			<input name="roleName" required lay-verify="required|checkRoleName" placeholder="请输入角色名称" autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">角色简介</label>
		<div class="layui-input-block">
			<input name="roleInfo" required lay-verify="required" placeholder="请输入角色简介" autocomplete="off" class="layui-input">
		</div>
	</div>
	
	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn" lay-submit lay-filter="btn_role_submit">立即提交</button>
			<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		</div>
	</div>
</form>
<script type="text/javascript" src="assert/pages/role/role_add_edit.js"></script>
