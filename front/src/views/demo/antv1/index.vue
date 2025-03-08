<template>
  <div class="dashboard">
    <!-- 统计卡片区域 -->
    <div class="stat-container">
      <div class="stat-card" :style="{ background: '#19be6b', color: 'white' }">
        <div class="card-icon">¥</div>
        <div class="card-content">
          <h3>今日收入</h3>
          <p>1530</p>
        </div>
      </div>
      <div class="stat-card" :style="{ background: '#ff4949', color: 'white' }">
        <div class="card-icon">👤</div>
        <div class="card-content">
          <h3>用户总数</h3>
          <p>1</p>
        </div>
      </div>
      <div class="stat-card" :style="{ background: '#409eff', color: 'white' }">
        <div class="card-icon">P</div>
        <div class="card-content">
          <h3>剩余车位</h3>
          <p>100/100</p>
        </div>
      </div>
      <div class="stat-card" :style="{ background: '#9062ff', color: 'white' }">
        <div class="card-icon">📝</div>
        <div class="card-content">
          <h3>车辆记录</h3>
          <p>4条</p>
        </div>
      </div>
    </div>

    <!-- 图表区域 -->
    <div class="charts-container">
      <div class="chart-box">
        <div class="chart-title">停车场剩余车位</div>
        <div id="pieChart" style="height: 300px;"></div>
      </div>
      <div class="chart-box">
        <div class="chart-title">车辆进出情况</div>
        <div id="barChart" style="height: 300px;"></div>
      </div>
    </div>
  </div>
</template>

<script>
import { onMounted } from 'vue';
import { Pie, Bar } from '@antv/g2plot';

export default {
  name: 'IndexPage',
  setup() {
    onMounted(() => {
      try {
        // 初始化饼图
        const pieChart = new Pie('pieChart', {
          data: [
            { value: 30, name: 'A区' },
            { value: 20, name: 'B区' },
            { value: 25, name: 'C区' },
            { value: 25, name: 'D区' }
          ],
          angleField: 'value',
          colorField: 'name',
          radius: 0.8,
          label: {
            type: 'inner',
            offset: '-30%',
            content: '{name}: {value}',
            style: {
              fontSize: 12
            }
          },
          legend: {
            position: 'top'
          }
        });
        pieChart.render();

        // 初始化柱状图
        const barChart = new Bar('barChart', {
          data: [
            { date: '11-08', in: 2, out: 2 },
            { date: '11-09', in: 2, out: 2 },
            { date: '11-14', in: 2, out: 2 }
          ],
          xField: 'date',
          yField: ['in', 'out'],
          stack: true,
          color: {
            in: '#e0f2f1',
            out: '#fff3e0'
          },
          label: {
            position: 'top'
          },
          legend: {
            position: 'top'
          }
        });
        barChart.render();
      } catch (error) {
        console.error('图表渲染出错:', error);
      }
    });

    return {};
  }
};
</script>

<style scoped>
.dashboard {
  background: #f5f7fa;
  padding: 20px;
}

/* 统计卡片容器样式 */
.stat-container {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 20px;
  margin-bottom: 20px;
}

/* 统计卡片样式 */
.stat-card {
  background: white;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  padding: 20px;
  display: flex;
  align-items: center;
  gap: 15px;
}

/* 卡片图标样式 */
.card-icon {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 20px;
}

/* 卡片内容样式 */
.card-content h3 {
  color: #666;
  font-size: 14px;
  margin-bottom: 5px;
}

.card-content p {
  color: #333;
  font-size: 20px;
  font-weight: bold;
}

/* 图表容器样式 */
.charts-container {
  display: flex;
  gap: 20px;
}

/* 单个图表盒子样式 */
.chart-box {
  flex: 1;
  background: white;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  padding: 20px;
}

/* 图表标题样式 */
.chart-title {
  color: #333;
  font-size: 18px;
  margin-bottom: 15px;
}
</style>